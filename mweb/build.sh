#!/bin/sh

build() {
    os=$1
    if [ $os = windows ]; then
        os=win32
    fi
    case $2 in
        amd64) arch=x86-64 ;;
        arm64) arch=aarch64 ;;
    esac
    CGO_ENABLED=1 GOOS=$1 GOARCH=$2 \
    go build -buildmode=c-shared \
             -buildvcs=false \
             -ldflags='-s -w' \
             -o ../src/main/resources/$os-$arch/$3
    rm ../src/main/resources/$os-$arch/*.h
}

build darwin amd64 libmweb.dylib
build darwin arm64 libmweb.dylib

export CC=x86_64-linux-gnu-gcc
build linux amd64 libmweb.so

export CC=aarch64-linux-gnu-gcc
build linux arm64 libmweb.so

export CC=x86_64-w64-mingw32-gcc
build windows amd64 mweb.dll
