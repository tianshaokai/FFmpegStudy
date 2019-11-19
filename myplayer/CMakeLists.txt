# 设置Cmake最小版本
cmake_minimum_required(VERSION 3.4.1)

#输出详细信息
set(CMAKE_VERBOSE_MAKEFILE on)

# 编译library # SHARED模式会编译so文件，STATIC模式不会编译
add_library(ffmpeg_player SHARED
        src/main/cpp/FFmpegPlayer.cpp)

#设置库目录，以下会用到
set(LIBRARY_DIRS ${CMAKE_SOURCE_DIR}/src/main/jniLibs)

message("JNILib: " STATUS ${LIBRARY_DIRS})

# 包含头文件目录
include_directories(../myplayer/src/main/cpp/include)

#添加 libavcodec 的动态库
add_library(avcodec SHARED IMPORTED )
#指定库路径
set_target_properties(avcodec PROPERTIES IMPORTED_LOCATION ${LIBRARY_DIRS}/${ANDROID_ABI}/libavcodec.so)

#添加 libavfilter 的动态库
add_library(avfilter SHARED IMPORTED )
#指定库路径
set_target_properties(avfilter PROPERTIES IMPORTED_LOCATION ${LIBRARY_DIRS}/${ANDROID_ABI}/libavfilter.so)

#添加 libavformat 的动态库
add_library(avformat SHARED IMPORTED )
#指定库路径
set_target_properties(avformat PROPERTIES IMPORTED_LOCATION ${LIBRARY_DIRS}/${ANDROID_ABI}/libavformat.so)

#添加 libavutil 的动态库
add_library(avutil SHARED IMPORTED )
#指定库路径
set_target_properties(avutil PROPERTIES IMPORTED_LOCATION ${LIBRARY_DIRS}/${ANDROID_ABI}/libavutil.so)

#添加 libswresample 的动态库
add_library(swresample SHARED IMPORTED )
#指定库路径
set_target_properties(swresample PROPERTIES IMPORTED_LOCATION ${LIBRARY_DIRS}/${ANDROID_ABI}/libswresample.so)

#添加 libswscale 的动态库
add_library(swscale SHARED IMPORTED )
#指定库路径
set_target_properties(swscale PROPERTIES IMPORTED_LOCATION ${LIBRARY_DIRS}/${ANDROID_ABI}/libswscale.so)


find_library(log-lib log)

target_link_libraries(
        ffmpeg_player

        # Links the target library to the log library
        # included in the NDK.
        avcodec
        avfilter
        avformat
        avutil
        swresample
        swscale

        ${log-lib})