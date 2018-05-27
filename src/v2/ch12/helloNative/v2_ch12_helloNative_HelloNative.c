/*
   @version 1.10 1997-07-01
   @author Cay Horstmann
*/

#include "v2_ch12_helloNative_HelloNative.h"
#include <stdio.h>
/**
 * 编译命令：
 * 进入当前C代码目录执行以下编译命令
 * gcc -fPIC -I ${JAVA_HOME}/include/ -I ${JAVA_HOME}/include/linux -shared -o libHelloNative.so v2_ch12_helloNative_HelloNative.c
 */
JNIEXPORT void JNICALL Java_v2_ch12_helloNative_HelloNative_greeting(JNIEnv* env, jclass cl)
{  
   printf("Hello Native World!\n");
}
