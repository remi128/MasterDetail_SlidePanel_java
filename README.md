# MasterDetail_SlidePanel_java

A java implementation of the tutorial
at https://developer.android.com/codelabs/basic-android-kotlin-training-adaptive-layouts#0

It creates a master/detail view for android by using a slide panel layout

To get the initial state of the app, checkout the branch "start_code" and run it on Phone device
and tablet device

add library slidingpanelayout to build.gradle ( app ):<br/>
<code>implementation 'androidx.slidingpanelayout:slidingpanelayout:1.2.0'</code>

Modify fragment_sports_list.xml by changing FrameLayout to SlidingPanelLayout, add an id to the
SlidingPanelLayout ( android:id="@+id/sliding_pane_layout" )

Add a second pane to the layout:

- add FragmentContainerView below the RecyclerView
- add an id to the FragmentContainerView android:id="@+id/detail_container"

Add NewsDetailsFragment to the FragmentContainerView by using the android:name attribut:<br>
android:name="de.remi.masterdetail.NewsDetailsFragment"

Update layout_width attribute of the RecyclerView (550 dp) and the FragmentContainer ( 300 dp)
Run the app on tablet and phone -> display is initially not bad, but click on tablet shows
single content frame

add layout_weight to FragmentContainer, to let it take available space
<code>android:layout_weight="1"</code>

Fixing the click on an item
change the code in SportsListFragment from
<code>
NavDirections action =
SportsListFragmentDirections.actionSportsListFragmentToSportsNewsFragment();
Navigation.findNavController(requireView()).navigate(action);
</code>

to

<code> binding.slidingPaneLayout.openPane() </code>
Run the app on both devices, clicks are properly displayed, but on phone the back navigation is 
gone, only slide back works

Add custom back navigation:

- create class SportsListOnBackPressedCallback extends OnBackPressedCallback implements
  SlidingPaneLayout.PanelSlideListener
- constructor:
- <code>        public SportsListOnBackPressedCallback(SlidingPaneLayout slidingPaneLayout) {
            super(slidingPaneLayout.isSlideable() && slidingPaneLayout.isOpen());
            this.slidingPaneLayout = slidingPaneLayout;
        }

</code>
implement required methods and define:
<code>
        @Override
        public void onPanelOpened(@NonNull View panel) {
            setEnabled(true);
        }

        @Override
        public void onPanelClosed(@NonNull View panel) {
            setEnabled(false);
        }

</code>


add to constructor of SportsListOnBackPressedCallback:
<code>            slidingPaneLayout.addPanelSlideListener(this); </code>

in onViewCreated, add
<code>
SlidingPaneLayout slidingPaneLayout = binding.slidingPaneLayout;
SportsListOnBackPressedCallback callback = new SportsListOnBackPressedCallback(slidingPaneLayout);
requireActivity().getOnBackPressedDispatcher().addCallback(callback);
</code>
