SUMMARY = "KDE's audio mixer"
LICENSE = "GPLv2 & GFDL-1.2 & LGPLv2"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://COPYING.DOC;md5=24ea4c7092233849b4394699333b5c56 \
    file://COPYING.LIB;md5=5f30f0716dfdd0d91eb439ebec522ec2 \
"

inherit kde-apps

DEPENDS += " \
    alsa-lib \
    libcanberra \
    \
    kconfigwidgets \
    kdbusaddons \
    kdelibs4support \
    kglobalaccel \
    ki18n \
    kiconthemes \
    kxmlgui \
    plasma-framework \
"

PACKAGECONFIG = "pulseaudio"    
PACKAGECONFIG[pulseaudio] = ",,pulseaudio"

PV = "${KDE_APP_VERSION}"
SRC_URI[md5sum] = "bd5c16d96136164ab84442aff05c5b6e"
SRC_URI[sha256sum] = "930acffff2d5116fa4237ed886ab0aeb3d57004e7411c7b04b4a61d3be021d60"

SRC_URI += "file://0001-fix-build-with-QT_NO_SESSIONMANAGER-set.patch"

EXTRA_OECMAKE += "-DKMIX_KF5_BUILD=1"

FILES_SOLIBSDEV = ""

FILES_${PN} += " \
    ${datadir}/k*5 \
    ${datadir}/plasma \
    ${datadir}/icons \
    ${datadir}/dbus-1 \
    \
    ${libdir}/libkdeinit5*.so \
    ${OE_QMAKE_PATH_PLUGINS} \
"

FILES_${PN}-dbg += " \
    ${OE_QMAKE_PATH_PLUGINS}/.debug \
    ${OE_QMAKE_PATH_PLUGINS}/plasma/*/.debug \
"
