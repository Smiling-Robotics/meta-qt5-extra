SUMMARY = "Qt port of libfm - a library to build desktop file managers"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=435ed639f84d4585d93824e7da3d85da"

REQUIRED_DISTRO_FEATURES = "x11"

inherit lxqt pkgconfig features_check cmake_auto_align_paths cmake_lib mime

DEPENDS += "qtx11extras glib-2.0 libexif menu-cache libxcb liblxqt"

CMAKE_ALIGN_FILES_FIND = "*targets.cmake"

SRCREV = "50a8f20c82443b00702a61f150ab4c0d71878116"
PV = "0.14.1"

FILES_${PN} += " \
    ${datadir}/mime \
    ${datadir}/${BPN}/*.list \
"

RRECOMMENDS_${PN} = "gvfs gvfsd-trash eject"

CMAKE_ALIGN_SYSROOT[1] = "fm-qt, -S${libdir}/lib, -s${OE_QMAKE_PATH_HOST_LIBS}/lib"
CMAKE_ALIGN_SYSROOT[2] = "fm-qt, -S${libdir}/glib, -s${OE_QMAKE_PATH_HOST_LIBS}/glib"
CMAKE_ALIGN_SYSROOT[3] = "fm-qt, -S${includedir}, -s${CMAKE_QT5_EX_PATH_HOST_HEADERS}"
