package com.peacecorps.pcsa;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<SplashScreenActivity> mActivityTestRule = new ActivityTestRule<>(SplashScreenActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.edit_name), isDisplayed()));
        appCompatEditText.perform(replaceText("XYZ"));

        ViewInteraction appCompatSpinner = onView(
                allOf(withId(R.id.spinner_country), isDisplayed()));
        appCompatSpinner.perform(click());

        ViewInteraction textView = onView(
                allOf(withText("Uganda"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("Uganda")));

        ViewInteraction textView2 = onView(
                allOf(withText("Syria"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView2.check(matches(withText("Syria")));

        ViewInteraction textView3 = onView(
                allOf(withText("Tunisia"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                2),
                        isDisplayed()));
        textView3.check(matches(withText("Tunisia")));

        ViewInteraction textView4 = onView(
                allOf(withText("Tunisia"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                2),
                        isDisplayed()));
        textView4.check(matches(withText("Tunisia")));

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.loginButton), withText("Login"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction button = onView(
                allOf(withId(R.id.getButton),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                1),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction button2 = onView(
                allOf(withId(R.id.circleButton),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                2),
                        isDisplayed()));
        button2.check(matches(isDisplayed()));

        ViewInteraction button3 = onView(
                allOf(withId(R.id.safetyToolsButton),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                3),
                        isDisplayed()));
        button3.check(matches(isDisplayed()));

        ViewInteraction button4 = onView(
                allOf(withId(R.id.supportServicesButton),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                4),
                        isDisplayed()));
        button4.check(matches(isDisplayed()));

        ViewInteraction button5 = onView(
                allOf(withId(R.id.assaultAwarenessButton),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                5),
                        isDisplayed()));
        button5.check(matches(isDisplayed()));

        ViewInteraction button6 = onView(
                allOf(withId(R.id.policiesButton),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                6),
                        isDisplayed()));
        button6.check(matches(isDisplayed()));

        ViewInteraction button7 = onView(
                allOf(withId(R.id.policiesButton),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                6),
                        isDisplayed()));
        button7.check(matches(isDisplayed()));

        ViewInteraction imageButton = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        withParent(withId(R.id.toolbar)),
                        isDisplayed()));
        imageButton.perform(click());

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.list_text), withText("Safety Plan"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.navbar_expandable_listview),
                                        3),
                                0),
                        isDisplayed()));
        textView5.check(matches(withText("Safety Plan")));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.header_text), withText("Support Services"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.navbar_expandable_listview),
                                        4),
                                0),
                        isDisplayed()));
        textView6.check(matches(withText("Support Services")));

        ViewInteraction textView7 = onView(
                allOf(withId(R.id.list_text), withText("Benefits of Seeking Staff Support"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.navbar_expandable_listview),
                                        5),
                                0),
                        isDisplayed()));
        textView7.check(matches(withText("Benefits of Seeking Staff Support")));

        ViewInteraction textView8 = onView(
                allOf(withId(R.id.list_text), withText("Benefits of Seeking Staff Support"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.navbar_expandable_listview),
                                        5),
                                0),
                        isDisplayed()));
        textView8.check(matches(withText("Benefits of Seeking Staff Support")));

        pressBack();

        ViewInteraction imageButton2 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        withParent(withId(R.id.toolbar)),
                        isDisplayed()));
        imageButton2.perform(click());

        ViewInteraction imageButton3 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        withParent(withId(R.id.toolbar)),
                        isDisplayed()));
        imageButton3.perform(click());

        ViewInteraction imageButton4 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        withParent(withId(R.id.toolbar)),
                        isDisplayed()));
        imageButton4.perform(click());

        ViewInteraction textView9 = onView(
                allOf(withId(R.id.header_text), withText("User logged in : XYZ"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.navbar_expandable_listview),
                                        6),
                                0),
                        isDisplayed()));
        textView9.check(matches(withText("User logged in : XYZ")));

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.menu_settings), withContentDescription("Settings"), isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction textView10 = onView(
                allOf(withId(android.R.id.summary), withText("XYZ"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView10.check(matches(withText("XYZ")));

        ViewInteraction textView11 = onView(
                allOf(withId(android.R.id.summary), withText("Uganda"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView11.check(matches(withText("Uganda")));

        ViewInteraction textView12 = onView(
                allOf(withId(android.R.id.summary), withText("Uganda"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView12.check(matches(withText("Uganda")));

        ViewInteraction linearLayout = onView(
                allOf(childAtPosition(
                        withId(android.R.id.list),
                        0),
                        isDisplayed()));
        linearLayout.perform(click());

        ViewInteraction editText = onView(
                allOf(withId(android.R.id.edit), withText("XYZ"),
                        withParent(withClassName(is("android.widget.LinearLayout")))));
        editText.perform(scrollTo(), click());

        ViewInteraction editText2 = onView(
                allOf(withId(android.R.id.edit), withText("XYZ"),
                        withParent(withClassName(is("android.widget.LinearLayout")))));
        editText2.perform(scrollTo(), click());

        ViewInteraction editText3 = onView(
                allOf(withId(android.R.id.edit), withText("XYZ"),
                        withParent(withClassName(is("android.widget.LinearLayout")))));
        editText3.perform(scrollTo(), replaceText("PeaceCorps"));

        pressBack();

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        withParent(allOf(withClassName(is("com.android.internal.widget.ButtonBarLayout")),
                                withParent(withClassName(is("android.widget.LinearLayout"))))),
                        isDisplayed()));
        appCompatButton2.perform(click());

        pressBack();

        ViewInteraction imageButton5 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        withParent(withId(R.id.toolbar)),
                        isDisplayed()));
        imageButton5.perform(click());

        ViewInteraction textView13 = onView(
                allOf(withId(R.id.header_text), withText("User logged in : PeaceCorps"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.navbar_expandable_listview),
                                        6),
                                0),
                        isDisplayed()));
        textView13.check(matches(withText("User logged in : PeaceCorps")));

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.getButton), withText("Get Help now")));
        appCompatButton3.perform(scrollTo(), click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.post_staff_pcmo), withText("Contact PCMO")));
        appCompatButton4.perform(scrollTo(), click());

        ViewInteraction appCompatImageView = onView(
                withId(R.id.link_to_other_staff));
        appCompatImageView.perform(scrollTo(), click());

        ViewInteraction appCompatImageView2 = onView(
                withId(R.id.link_to_post_staff));
        appCompatImageView2.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.circleButton), withText("Circle of Trust")));
        appCompatButton5.perform(scrollTo(), click());

        ViewInteraction imageButton6 = onView(
                allOf(withId(R.id.next), isDisplayed()));
        imageButton6.perform(click());

        ViewInteraction imageButton7 = onView(
                allOf(withId(R.id.next), isDisplayed()));
        imageButton7.perform(click());

        ViewInteraction imageButton8 = onView(
                allOf(withId(R.id.next), isDisplayed()));
        imageButton8.perform(click());

        ViewInteraction imageButton9 = onView(
                allOf(withId(R.id.next), isDisplayed()));
        imageButton9.perform(click());

        ViewInteraction button8 = onView(
                allOf(withId(R.id.done), withText("Done"), isDisplayed()));
        button8.perform(click());

        ViewInteraction appCompatImageButton = onView(
                withId(R.id.requestButton));
        appCompatImageButton.perform(scrollTo(), click());

        ViewInteraction textView14 = onView(
                allOf(withId(R.id.messagedialog_txt), withText("Come get me"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.dialog_listview),
                                        1),
                                0),
                        isDisplayed()));
        textView14.check(matches(withText("Come get me")));

        ViewInteraction textView15 = onView(
                allOf(withText("Select a request"),
                        childAtPosition(
                                allOf(withId(R.id.dialog_listview),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                                0)),
                                0),
                        isDisplayed()));
        textView15.check(matches(withText("Select a request")));

        ViewInteraction appCompatImageButton2 = onView(
                withId(R.id.editButton));
        appCompatImageButton2.perform(scrollTo(), click());

        ViewInteraction appCompatEditText2 = onView(
                withId(R.id.comrade1EditText));
        appCompatEditText2.perform(scrollTo(), click());

        ViewInteraction appCompatEditText3 = onView(
                withId(R.id.comrade1EditText));
        appCompatEditText3.perform(scrollTo(), replaceText("9986188939"));

        pressBack();

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.okButton), withText("Save")));
        appCompatButton6.perform(scrollTo(), click());

        ViewInteraction textView16 = onView(
                allOf(withId(R.id.com1ButtonName), withText("9986188939"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView16.check(matches(withText("9986188939")));

        pressBack();

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.safetyToolsButton), withText("Safety Tools")));
        appCompatButton7.perform(scrollTo(), click());

        ViewInteraction button9 = onView(
                allOf(withId(R.id.radarButton),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                1),
                        isDisplayed()));
        button9.check(matches(isDisplayed()));

        ViewInteraction button10 = onView(
                allOf(withId(R.id.radarButton),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                1),
                        isDisplayed()));
        button10.check(matches(isDisplayed()));

        ViewInteraction button11 = onView(
                allOf(withId(R.id.unwantedAttentionButton),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                2),
                        isDisplayed()));
        button11.check(matches(isDisplayed()));

        ViewInteraction button12 = onView(
                allOf(withId(R.id.tacticsButton),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                3),
                        isDisplayed()));
        button12.check(matches(isDisplayed()));

        ViewInteraction button13 = onView(
                allOf(withId(R.id.bystanderButton),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                4),
                        isDisplayed()));
        button13.check(matches(isDisplayed()));

        ViewInteraction button14 = onView(
                allOf(withId(R.id.safetyPlanBasicsButton),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                5),
                        isDisplayed()));
        button14.check(matches(isDisplayed()));

        ViewInteraction button15 = onView(
                allOf(withId(R.id.safetyPlanButton),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                6),
                        isDisplayed()));
        button15.check(matches(isDisplayed()));

        ViewInteraction textView17 = onView(
                allOf(withText("Know all about your Safety Tools"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                0),
                        isDisplayed()));
        textView17.check(matches(withText("Know all about your Safety Tools")));

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.radarButton), withText("RADAR")));
        appCompatButton8.perform(scrollTo(), click());

        ViewInteraction appCompatImageView3 = onView(
                allOf(withId(R.id.next_step),
                        withParent(withId(R.id.radar_controller)),
                        isDisplayed()));
        appCompatImageView3.perform(click());

        ViewInteraction appCompatImageView4 = onView(
                allOf(withId(R.id.next_step),
                        withParent(withId(R.id.radar_controller)),
                        isDisplayed()));
        appCompatImageView4.perform(click());

        ViewInteraction textView18 = onView(
                allOf(withId(R.id.steps_text), withText("STEP 3"),
                        childAtPosition(
                                allOf(withId(R.id.radar_controller),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                                1)),
                                1),
                        isDisplayed()));
        textView18.check(matches(withText("STEP 3")));

        ViewInteraction appCompatImageView5 = onView(
                allOf(withId(R.id.next_step),
                        withParent(withId(R.id.radar_controller)),
                        isDisplayed()));
        appCompatImageView5.perform(click());

        ViewInteraction textView19 = onView(
                allOf(withId(R.id.steps_text), withText("STEP 4"),
                        childAtPosition(
                                allOf(withId(R.id.radar_controller),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                                1)),
                                1),
                        isDisplayed()));
        textView19.check(matches(withText("STEP 4")));

        pressBack();

        ViewInteraction appCompatButton9 = onView(
                allOf(withId(R.id.unwantedAttentionButton), withText("Unwanted Attention")));
        appCompatButton9.perform(scrollTo(), click());

        ViewInteraction textView20 = onView(
                allOf(withId(R.id.faqtitle), withText("Walk purposefully"),
                        childAtPosition(
                                allOf(withId(R.id.faq_title_and_image),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                                0)),
                                1),
                        isDisplayed()));
        textView20.check(matches(withText("Walk purposefully")));

        pressBack();

        ViewInteraction appCompatButton10 = onView(
                allOf(withId(R.id.tacticsButton), withText("Tactics of Sexual Predators")));
        appCompatButton10.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatButton11 = onView(
                allOf(withId(R.id.bystanderButton), withText("Bystander Intervention")));
        appCompatButton11.perform(scrollTo(), click());

        ViewInteraction appCompatButton12 = onView(
                allOf(withId(R.id.tacticsForBoth), withText("Non Verbal Tactics for both"), isDisplayed()));
        appCompatButton12.perform(click());

        pressBack();

        pressBack();

        ViewInteraction appCompatButton13 = onView(
                allOf(withId(R.id.safetyPlanButton), withText("Safety Plan")));
        appCompatButton13.perform(scrollTo(), click());

        ViewInteraction appCompatButton14 = onView(
                allOf(withId(R.id.actionButton), withText("View Actions"), isDisplayed()));
        appCompatButton14.perform(click());

        ViewInteraction appCompatButton15 = onView(
                allOf(withId(R.id.actionButton), withText("View Concerns"), isDisplayed()));
        appCompatButton15.perform(click());

        pressBack();

        ViewInteraction appCompatButton16 = onView(
                allOf(withId(R.id.safetyPlanBasicsButton), withText("Safety Plan Basics")));
        appCompatButton16.perform(scrollTo(), click());

        ViewInteraction appCompatButton17 = onView(
                allOf(withId(R.id.plansCannot), withText("SAFETY PLANS CANNOT ..."), isDisplayed()));
        appCompatButton17.perform(click());

        ViewInteraction appCompatButton18 = onView(
                allOf(withId(R.id.tips), withText("TIPS FOR CREATING SAFETY PLAN"), isDisplayed()));
        appCompatButton18.perform(click());

        pressBack();

        pressBack();

        ViewInteraction appCompatButton19 = onView(
                allOf(withId(R.id.supportServicesButton), withText("Support Services")));
        appCompatButton19.perform(scrollTo(), click());

        ViewInteraction floatingActionButton = onView(
                withId(R.id.supportHelpFabButton));
        floatingActionButton.perform(scrollTo(), click());

        ViewInteraction appCompatButton20 = onView(
                allOf(withId(R.id.benefitsButton), withText("Benefits of Seeking Staff Support")));
        appCompatButton20.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatButton21 = onView(
                allOf(withId(R.id.servicesButton), withText("Services after a Sexual Assault")));
        appCompatButton21.perform(scrollTo(), click());

        ViewInteraction appCompatButton22 = onView(
                allOf(withId(R.id.reporting_faq), withText("Learn More about the Reporting Types"), isDisplayed()));
        appCompatButton22.perform(click());

        pressBack();

        pressBack();

        ViewInteraction appCompatButton23 = onView(
                allOf(withId(R.id.benefitsButton), withText("Benefits of Seeking Staff Support")));
        appCompatButton23.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatButton24 = onView(
                allOf(withId(R.id.afterButton), withText("What to do After an Assault?")));
        appCompatButton24.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatButton25 = onView(
                allOf(withId(R.id.confidentialityButton), withText("Confidentiality")));
        appCompatButton25.perform(scrollTo(), click());

        ViewInteraction appCompatButton26 = onView(
                allOf(withId(R.id.staffButton), withText("Role of Staff")));
        appCompatButton26.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatButton27 = onView(
                allOf(withId(R.id.confidentialityButton), withText("Confidentiality")));
        appCompatButton27.perform(scrollTo(), click());

        ViewInteraction appCompatButton28 = onView(
                allOf(withId(R.id.communityButton), withText("Role of Volunteer Community")));
        appCompatButton28.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatButton29 = onView(
                allOf(withId(R.id.assaultedButton), withText("Role of Assaulted Volunteer")));
        appCompatButton29.perform(scrollTo(), click());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.safety_plan_basics_content), withText("If you become the victim of a crime, choose who you trust with your sensitive information. Volunteer communications with other Volunteers may not be held to the same rules of privacy that apply to Peace Corps staff or Hotline responders.\nAs one Volunteer shared:\n\n“After the sexual assault, I needed the support of a fellow PCV and shared a little about what I was going through. I had no idea that because I was seeking legal justice that the defense lawyer would contact that individual four months later to fish for information to use against me in a court of law. Had I known that anything that I said verbally or in an email would be fair game for court, I would have been more cautious and spoken to a counselor through secure communication earlier.”\n"),
                        withParent(allOf(withId(R.id.myView),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatTextView.perform(click());

        pressBack();

        pressBack();

        pressBack();

        ViewInteraction appCompatButton30 = onView(
                allOf(withId(R.id.assaultAwarenessButton), withText("Sexual Assault Awareness")));
        appCompatButton30.perform(scrollTo(), click());

        ViewInteraction appCompatButton31 = onView(
                allOf(withId(R.id.wasButton), withText("Was it Sexual Assault?")));
        appCompatButton31.perform(scrollTo(), click());

        ViewInteraction appCompatButton32 = onView(
                allOf(withId(R.id.knowButton), withText("Sexual Assault")));
        appCompatButton32.perform(scrollTo(), click());

        pressBack();

        pressBack();

        ViewInteraction appCompatButton33 = onView(
                allOf(withId(R.id.commonButton), withText("Sexual Assault Common Questions")));
        appCompatButton33.perform(scrollTo(), click());

        ViewInteraction linearLayout2 = onView(
                allOf(withId(R.id.faq_title_and_image),
                        withParent(childAtPosition(
                                withId(android.R.id.list),
                                2)),
                        isDisplayed()));
        linearLayout2.perform(click());

        ViewInteraction linearLayout3 = onView(
                allOf(withId(R.id.faq_title_and_image),
                        withParent(childAtPosition(
                                withId(android.R.id.list),
                                2)),
                        isDisplayed()));
        linearLayout3.perform(click());

        pressBack();

        ViewInteraction appCompatButton34 = onView(
                allOf(withId(R.id.harassmentButton), withText("Sexual Harassment")));
        appCompatButton34.perform(scrollTo(), click());

        ViewInteraction appCompatButton35 = onView(
                allOf(withId(R.id.knowButton), withText("Learn more about Sexual Harassment")));
        appCompatButton35.perform(scrollTo(), click());

        pressBack();

        pressBack();

        ViewInteraction appCompatButton36 = onView(
                allOf(withId(R.id.helpingButton), withText("Helping Others")));
        appCompatButton36.perform(scrollTo(), click());

        pressBack();

        pressBack();

        ViewInteraction appCompatButton37 = onView(
                allOf(withId(R.id.policiesButton), withText("Policies and Glossary")));
        appCompatButton37.perform(scrollTo(), click());

        ViewInteraction appCompatButton38 = onView(
                allOf(withId(R.id.glossaryButton), withText("Glossary")));
        appCompatButton38.perform(scrollTo(), click());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.inputSearch), isDisplayed()));
        appCompatEditText4.perform(replaceText("aggr"));

        pressBack();

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.inputSearch), withText("aggr"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.fragment_container),
                                        0),
                                1),
                        isDisplayed()));
        editText4.check(matches(withText("aggr")));

        ViewInteraction textView21 = onView(
                allOf(withId(R.id.word_title), withText("Aggravated Sexual Assault"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.list_words),
                                        0),
                                0),
                        isDisplayed()));
        textView21.check(matches(withText("Aggravated Sexual Assault")));

        ViewInteraction textView22 = onView(
                allOf(withId(R.id.word_title), withText("Aggravated Sexual Assault"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.list_words),
                                        0),
                                0),
                        isDisplayed()));
        textView22.check(matches(withText("Aggravated Sexual Assault")));

        pressBack();

        ViewInteraction appCompatButton39 = onView(
                allOf(withId(R.id.furtherButton), withText("Further Resources")));
        appCompatButton39.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatButton40 = onView(
                allOf(withId(R.id.policiesButton), withText("Peace Corps Policies")));
        appCompatButton40.perform(scrollTo(), click());

        ViewInteraction imageButton10 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        withParent(withId(R.id.toolbar)),
                        isDisplayed()));
        imageButton10.perform(click());

        ViewInteraction imageButton11 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        withParent(withId(R.id.toolbar)),
                        isDisplayed()));
        imageButton11.perform(click());

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
