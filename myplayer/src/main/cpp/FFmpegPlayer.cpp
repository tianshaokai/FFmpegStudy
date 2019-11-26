//
// Created by 小鹏 on 2019-11-19.
//
#include <jni.h>
#include "android_log.h"

extern "C" {
#include <libavcodec/avcodec.h>
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_tianshaokai_myplayer_MyPlayer_getffmpegInfo(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF(avcodec_configuration());
}

extern "C"
JNIEXPORT void JNICALL
Java_com_tianshaokai_myplayer_MyPlayer_n_1prepared(JNIEnv *env, jobject thiz, jstring url) {
    LOGD("MyPlayer prepared");


}


