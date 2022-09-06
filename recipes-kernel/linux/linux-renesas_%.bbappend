#require ${@bb.utils.contains('USE_DOWNSTREAM_LINUXRENESAS', '1', 'linux-renesas-kingfisher.inc', '', d)}
#require ${@bb.utils.contains('USE_DOWNSTREAM_LINUXRENESAS', '1', 'require linux-renesas-extra.inc', '', d)}
