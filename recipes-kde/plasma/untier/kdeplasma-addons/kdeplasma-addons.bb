SUMMARY = "All kind of addons to improve your Plasma experience"
LICENSE = "GPLv2 & LGPLv2.1"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24 \
    file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1 \
"

inherit kde-plasma

DEPENDS += " \
    qtdeclarative \
    \
    kconfig \
    kconfigwidgets \
    kcoreaddons \
    ki18n \
    kcmutils \
    plasma-framework \
    krunner \
    kservice \
    sonnet \
    kunitconversion \
    kdelibs4support \
    kross \
    knewstuff \
    \
    ${@bb.utils.contains("DISTRO_FEATURES", "x11", "virtual/xserver qtx11extras", "", d)} \
"

PV = "${PLASMA_VERSION}"
SRC_URI[md5sum] = "d5eadc6779cd8679c2aeadd8d6f1df02"
SRC_URI[sha256sum] = "3486d8bf1e686d33196b342dc5c8d47ce9c3c6e3178ace72faf37ce51bb9a944"

FILES_${PN} += " \
    ${datadir}/kwin \
    ${datadir}/k*5 \
    ${datadir}/plasma \
    ${datadir}/icons \
    \
    ${OE_QMAKE_PATH_PLUGINS} \
    ${OE_QMAKE_PATH_QML} \
"

FILES_${PN}-dbg += " \
    ${OE_QMAKE_PATH_PLUGINS}/.debug \
    ${OE_QMAKE_PATH_PLUGINS}/*/*/.debug \
    ${OE_QMAKE_PATH_QML}/org/kde/plasma/private/*/.debug \
"
