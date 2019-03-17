package consultation.rumpilstilstkin.ru.lesson7;


import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    MainActivity activity;

    @Before
    public  void init() {
        activity = rule.getActivity();
    }

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("consultation.rumpilstilstkin.ru.lesson7", appContext.getPackageName());
    }

    @Test
    public void ensureProgressViewExist() {
        View loadingView = activity.findViewById(R.id.loadingView);
        assertThat(loadingView, notNullValue());
        assertThat(loadingView, instanceOf(ProgressBar.class));
    }

    @Test
    public void ensureContentViewExist() {
        View contentView = activity.findViewById(R.id.contentView);
        assertThat(contentView, notNullValue());
        assertThat(contentView, instanceOf(RelativeLayout.class));
    }

    @Test
    public void ensureEmptyViewExist() {
        View emptyView = activity.findViewById(R.id.emptyView);
        assertThat(emptyView, notNullValue());
        assertThat(emptyView, instanceOf(FrameLayout.class));
    }

    @Test
    public void ensureProgressViewIsShowing() {
        View loadingView = activity.findViewById(R.id.loadingView);
        View content = activity.findViewById(R.id.contentView);
        View empty = activity.findViewById(R.id.emptyView);
        activity.showLoading();
        assertEquals(loadingView.getVisibility(), View.VISIBLE);
        assertEquals(content.getVisibility(), View.INVISIBLE);
        assertEquals(empty.getVisibility(), View.INVISIBLE);
    }

    @Test
    public void ensureProgressViewIsHide() {
        View viewById = activity.findViewById(R.id.loadingView);
        activity.hideLoading();
        assertEquals(viewById.getVisibility(), View.INVISIBLE);
    }

    @Test
    public void ensureContentViewIsShow() {
        View content = activity.findViewById(R.id.contentView);
        View empty = activity.findViewById(R.id.emptyView);
        activity.showRepoList(new ArrayList<>());
        assertEquals(content.getVisibility(), View.VISIBLE);
        assertEquals(empty.getVisibility(), View.INVISIBLE);
    }

    @Test
    public void ensureEmptyContentViewIsShow() {
        View content = activity.findViewById(R.id.contentView);
        View empty = activity.findViewById(R.id.emptyView);
        activity.showEmptyState();
        assertEquals(content.getVisibility(), View.INVISIBLE);
        assertEquals(empty.getVisibility(), View.VISIBLE);
    }
}
