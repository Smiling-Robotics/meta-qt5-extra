SUMMARY = "KDE's screen management software"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = " \
	file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
	file://COPYING.LIB;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
"

inherit kde-plasma cmake-lib

DEPENDS += " \
	${@bb.utils.contains("DISTRO_FEATURES", "wayland", "kwayland", "", d)} \
	${@bb.utils.contains("DISTRO_FEATURES", "x11", "virtual/xserver qtx11extras", "", d)} \
"

PV = "${PLASMA_VERSION}"
SRC_URI[md5sum] = "7a437d07e7dff6665c1978540fe577b4"
SRC_URI[sha256sum] = "5e2c38a436293ec4ba2f19237614e254a799808ee232818a053d439e5b8761ec"

SRC_URI += " \
    file://0001-fix-configuration-build-on-x-less-systems.patch \
"


FILES_${PN} += " \
    ${datadir}/dbus-1 \
    ${OE_QMAKE_PATH_PLUGINS} \
"

FILES_${PN}-dbg += " \
    ${OE_QMAKE_PATH_PLUGINS}/kf5/kscreen/.debug \
    ${libexecdir}/kf5/.debug \
"

CMAKE_ALIGN_SYSROOT[1] = "KF5Screen, -S${includedir}, -S${STAGING_INCDIR}"
CMAKE_ALIGN_SYSROOT[2] = "KF5Screen, -S${libdir}, -S${STAGING_LIBDIR}"

