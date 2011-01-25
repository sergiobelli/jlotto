/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sb.jlotto.shr;

import java.util.Collection;

/**
 *
 * @author sbelli
 */
public class Eval {
    public static final boolean isNull(Object obj) {
        return (obj == null);
    }
    public static final boolean isNotNull(Object obj) {
        return !isNull(obj);
    }
    public static final boolean areNotNulls(Object ... objs) {
        for (Object obj : objs) {
            if (isNull(obj)) {
                return false;
            }
        }
        return true;
    }
    public static final boolean isEmpty(String arg) {
        return (isNull(arg)) ? true : (arg.isEmpty() ? true : false);
    }
    public static final boolean isEmpty(Collection coll) {
        return isNull(coll) ? true : coll.isEmpty();
    }
    public static final boolean isNotEmpty(String arg) {
        return !isEmpty(arg);
    }
    public static final boolean isNotEmpty(Collection coll) {
        return !isEmpty(coll);
    }
}
