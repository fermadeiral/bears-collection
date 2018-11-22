package org.geotools.data.ogr.bridj;

import java.util.Collections;
import java.util.Iterator;
import org.bridj.BridJ;
import org.bridj.CRuntime;
import org.bridj.FlagSet;
import org.bridj.IntValuedEnum;
import org.bridj.Pointer;
import org.bridj.ValuedEnum;
import org.bridj.ann.Library;
import org.bridj.ann.Runtime;
import org.geotools.data.ogr.bridj.OsrLibrary.CPLErrorHandler;

/**
 * Wrapper for library <b>cplError</b><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a
 * href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource
 * projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a
 * href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("cplError")
@Runtime(CRuntime.class)
public class CplErrorLibrary {
    static {
        BridJ.register();
    }

    public enum CPLErr implements IntValuedEnum<CPLErr> {
        CE_None(0),
        CE_Debug(1),
        CE_Warning(2),
        CE_Failure(3),
        CE_Fatal(4);

        CPLErr(long value) {
            this.value = value;
        }

        public final long value;

        public long value() {
            return this.value;
        }

        public Iterator<CPLErr> iterator() {
            return Collections.singleton(this).iterator();
        }

        public static ValuedEnum<CPLErr> fromValue(long value) {
            return FlagSet.fromValue(value, values());
        }
    };
    /// <i>native declaration : /home/aaime/devel/gdal/gdal-1.8.0/port/cpl_error.h</i>
    public static final int CPLE_UserInterrupt = (int) 9;
    /// <i>native declaration : /home/aaime/devel/gdal/gdal-1.8.0/port/cpl_error.h</i>
    public static final int CPLE_NoWriteAccess = (int) 8;
    /// <i>native declaration : /home/aaime/devel/gdal/gdal-1.8.0/port/cpl_error.h</i>
    public static final int CPLE_ObjectNull = (int) 10;
    /// <i>native declaration : /home/aaime/devel/gdal/gdal-1.8.0/port/cpl_error.h</i>
    public static final int CPLE_IllegalArg = (int) 5;
    /// <i>native declaration : /home/aaime/devel/gdal/gdal-1.8.0/port/cpl_error.h</i>
    public static final int CPLE_None = (int) 0;
    /// <i>native declaration : /home/aaime/devel/gdal/gdal-1.8.0/port/cpl_error.h</i>
    public static final int CPLE_FileIO = (int) 3;
    /// <i>native declaration : /home/aaime/devel/gdal/gdal-1.8.0/port/cpl_error.h</i>
    public static final int CPLE_AssertionFailed = (int) 7;
    /// <i>native declaration : /home/aaime/devel/gdal/gdal-1.8.0/port/cpl_error.h</i>
    public static final int CPLE_NotSupported = (int) 6;
    /// <i>native declaration : /home/aaime/devel/gdal/gdal-1.8.0/port/cpl_error.h</i>
    public static final int CPLE_AppDefined = (int) 1;
    /// <i>native declaration : /home/aaime/devel/gdal/gdal-1.8.0/port/cpl_error.h</i>
    public static final int CPLE_OutOfMemory = (int) 2;
    /// <i>native declaration : /home/aaime/devel/gdal/gdal-1.8.0/port/cpl_error.h</i>
    public static final int CPLE_OpenFailed = (int) 4;

    public static native void CPLError(
            ValuedEnum<CplErrorLibrary.CPLErr> eErrClass,
            int err_no,
            Pointer<Byte> fmt,
            Object... varargs);

    public static native void CPLErrorV(
            ValuedEnum<CplErrorLibrary.CPLErr> CPLErr1, int int1, Pointer<Byte> charPtr1);

    public static native void CPLErrorReset();

    public static native int CPLGetLastErrorNo();

    public static native ValuedEnum<CplErrorLibrary.CPLErr> CPLGetLastErrorType();

    public static native Pointer<Byte> CPLGetLastErrorMsg();

    public static native void CPLLoggingErrorHandler(
            ValuedEnum<CplErrorLibrary.CPLErr> CPLErr1, int int1, Pointer<Byte> charPtr1);

    public static native void CPLDefaultErrorHandler(
            ValuedEnum<CplErrorLibrary.CPLErr> CPLErr1, int int1, Pointer<Byte> charPtr1);

    public static native void CPLQuietErrorHandler(
            ValuedEnum<CplErrorLibrary.CPLErr> CPLErr1, int int1, Pointer<Byte> charPtr1);

    public static native void CPLTurnFailureIntoWarning(int bOn);

    public static native Pointer<CPLErrorHandler> CPLSetErrorHandler(
            Pointer<CPLErrorHandler> CPLErrorHandler1);

    public static native void CPLPushErrorHandler(Pointer<CPLErrorHandler> CPLErrorHandler1);

    public static native void CPLPopErrorHandler();

    public static native void CPLDebug(
            Pointer<Byte> charPtr1, Pointer<Byte> charPtr2, Object... varargs);

    public static native void _CPLAssert(Pointer<Byte> charPtr1, Pointer<Byte> charPtr2, int int1);
}
