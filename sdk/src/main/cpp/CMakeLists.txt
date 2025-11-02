cmake_minimum_required(VERSION 3.18.1)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(OpenCV_DIR "${CMAKE_CURRENT_SOURCE_DIR}/opencv2/sdk/native/jni")

add_subdirectory(armneon2x86sse)
add_subdirectory(eigen)
add_subdirectory(protobuf)
add_subdirectory(caffe)
add_subdirectory(libyuv)
add_subdirectory(crossplatform)

add_library(data SHARED CardRecognizer-jni.cpp)

target_link_libraries(data
        PRIVATE
        crossplatform
        libyuv
        log # Android logging library
        z) # zlib

target_link_options(data PRIVATE "-Wl,-z,max-page-size=16384")

