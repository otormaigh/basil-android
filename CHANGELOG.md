Version 0.1.15 -
------------------------
 - remove ktlint replace with detekt
 - rename files names to make them more concise
 - update compile/targeSdk to 28
 - #18 Recipe detail page not updating

Version 0.1.14 - 8811536
------------------------
 - add listing descriptions
 - add launcher icon
 - add Falcon to take spoon screenshots, update play store listing screenshots
 - convert test over to jetpack artifacts
 - update gradle to 4.8

Version 0.1.13 - 01981ba
------------------------
 - add extension functions to help with setting OnTabSelectedListener>
 - update DirectionsPage to use merge tag on layout
 - convert RecipeMainActivity into BottomSheetDialogFragment
 - add ktlint to handle linting things

Version 0.1.12 - 342a794
------------------------
 - add android.injected.testOnly=false flag to gradle.properties

Version 0.1.11 - ead2e22
------------------------
 - remove debuggable flag from release build
 - fix some proguard issues, migrate constraintlayout to androidx
 - add dagger to manage di and room to manage data