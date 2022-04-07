DESCRIPTION = "Cgminer bitcoin miner SW"
#LICENSE = "GPLv3 & bzip2"
LICENSE = "CLOSED"
#LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
#LIC_FILES_CHKSUM = "file://COPYING"

DEPENDS = "ncurses curl"

#SRCREV = "v3.8.3-knc"
#PV = "${SRCREV}+git${SRCPV}"
SRCREV = "3.8.5"
#PV = "${SRCREV}+${SRCPV}"
PR = "r1"

#SRC_URI = "file://cgminer-4.11.0.tar.bz2"
SRC_URI = "file://cgminer-4.8.0.tar.bz2"
#SRC_URI = "http://ck.kolivas.org/apps/cgminer/4.11/cgminer-4.11.1.tar.bz2"
S = "${WORKDIR}/cgminer-4.8.0"

#SRC_URI[md5sum] = "4665fba149e19432c1c54864baf86a67"
#SRC_URI[sha256sum] = "a8f3e244343eda8c3410e6d27188ee941de25c54bd76412e5b4d17de9f30ac18"

#CFLAGS_prepend = "-I ${S}/compat/jansson-2.5/src -I ${S}/compat/libusb-1.0/libusb"
CFLAGS_prepend = "-I ${S}/compat/jansson-2.6/src -I ${S}/compat/libusb-1.0/libusb"


EXTRA_OECONF = " \
	     --enable-bitmain \
	     --disable-adl \
	     --disable-opencl \
	     --disable-libcurl \
	     "
		 
do_configure_prepend() {
	autoreconf -fiv
}

do_compile_append() {
	make api-example
}

do_install_append() {
        install -d ${D}${bindir}
        install -m 0755 ${S}/api-example ${D}${bindir}/cgminer-api
}
 
inherit autotools pkgconfig
