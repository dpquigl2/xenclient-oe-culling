DESCRIPTION = "Simple xsd validator"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=4641e94ec96f98fabc56ff9cc48be14b"
DEPENDS = "libxerces-c"

PV = "0+git${SRCPV}"

SRCREV = "${OPENXT_TAG}"
SRC_URI = "git://${OPENXT_GIT_MIRROR}/xctools.git;protocol=${OPENXT_GIT_PROTOCOL};branch=${OPENXT_BRANCH}"

S = "${WORKDIR}/git/xsd-validate"

inherit autotools
inherit xenclient

do_install_append() {
	install -d ${D}/usr/bin
	install -m 0755 ${S}/src/xsd-validate ${D}/usr/bin/xsd-validate
}
