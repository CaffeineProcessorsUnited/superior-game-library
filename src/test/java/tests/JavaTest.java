/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package tests;

import de.hnzlmnn.sgl.impl.types.SGLString;
import de.hnzlmnn.sgl.types.SGLObject;
import de.hnzlmnn.sgl.types.SGLType;
import de.hnzlmnn.sgl.types.VarUpdater;
import de.hnzlmnn.sgl.types.VarUpdaterData;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Malte Heinzelmann
 */
public class JavaTest {

    @Rule
    public Log4JTestWatcher test = new Log4JTestWatcher();

    @Test
    public void testTypeCasting() {
        SGLObject a1 = new SGLString("Test");
        SGLString s1;
        String s2;
        Assert.assertTrue("a1 can be casted to SGLString", (s1 = a1.to(SGLString.class)) != null);
        Assert.assertTrue("s1.get() == \"Test\"", s1.get() == "Test");
        Assert.assertTrue("a1 can be casted to String", (s2 = a1.to(String.class)) != null);
        Assert.assertTrue("s2.get() == \"Test\"", s2 == "Test");
    }

    @Test
    public void testReferenceUpdating() {
        SGLString v1 = new SGLString("foo");
        SGLString v2 = new SGLString("bar");
        v1.ref("v2", v2);
        v1.u(new VarUpdater<String>() {
            @Override
            public VarUpdaterData<String> update(SGLType<String> v) {
                test.log.debug("Updating reference");
                return new VarUpdaterData<String>(v.get() + v.ref("v2", String.class));
            }
        });
        v2.assign("baz");
        Assert.assertTrue("v1.get() == \"foobaz\"", v1.get().equals("foobaz"));
    }

    @Test
    public void testVariableInitializing() {
        SGLString v1 = new SGLString();
        SGLString v2 = new SGLString("foobar");
        v1.ref("v2", v2);
        v1.u(new VarUpdater<String>() {
            @Override
            public VarUpdaterData<String> update(SGLType<String> v) {
                test.log.debug("Updating reference");
                return new VarUpdaterData<String>(v.ref("v2", String.class));
            }
        });
        v1.init();
        Assert.assertTrue("v1.get() == \"foobar\"", v1.get().equals("foobar"));
    }
}
