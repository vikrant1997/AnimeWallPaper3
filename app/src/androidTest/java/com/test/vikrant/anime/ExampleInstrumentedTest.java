<<<<<<< HEAD:app/src/androidTest/java/com/test/vikrant/anime/ExampleInstrumentedTest.java
package com.test.vikrant.anime;
=======
package com.singh.vikrant.photos;
>>>>>>> e98aa7a509bf4e3795c36120bc8d906927bd9c8b:app/src/androidTest/java/com/test/vikrant/anime/ExampleInstrumentedTest.java

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.singh.vikrant.test1", appContext.getPackageName());
    }
}
