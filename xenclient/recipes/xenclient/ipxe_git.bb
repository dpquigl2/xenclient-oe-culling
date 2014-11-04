DESCRIPTION = "IPXE"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=8ca43cbc842c2336e835926c2166c28b"

SRCREV_FORMAT = "source_patchqueue"

PV = "0+git${SRCPV}"

SRCREV_source = "8d038040eaac85bbe08f0b5ba507ff0167b3a2f3"
SRCREV_patchqueue = "${OPENXT_TAG}"

SRC_URI = "git://git.ipxe.org/ipxe.git;protocol=git;name=source \
           git://${OPENXT_GIT_MIRROR}/ipxe-pq.git;protocol=${OPENXT_GIT_PROTOCOL};branch=${OPENXT_BRANCH};destsuffix=patchqueue;name=patchqueue \
          "

S = "${WORKDIR}/git"

inherit xenclient
inherit xenclient-pq

FILES_${PN} = "/usr/share/firmware/*.rom"

PARALLEL_MAKE=""
# Use host toolchain. God please forgive me.
EXTRA_OEMAKE += "CFLAGS= LDFLAGS= CC='${BUILD_CC}' LD='${BUILD_LD}'"

do_configure () {
        :
}

do_compile() {
        make -C src/ bin/rtl8139.rom
}

do_install() {
        install -d ${D}/usr/share/firmware
        install -m 0644 src/bin/rtl8139.rom ${D}/usr/share/firmware/
}

