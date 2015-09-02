#!/bin/sh

LAYERS_DIR=./sources/base/conf/
LAYER_VOIPAC_STRING="BBLAYERS += \"\${BSPDIR}/sources/meta-fsl-arm-voipac\""

if [ -w ${LAYERS_DIR}/bblayers.conf ]
then
	grep "${LAYER_VOIPAC_STRING}" "${LAYERS_DIR}/bblayers.conf" > /dev/null
	TMPRETVAL=$(echo $?)
	TMPPRINT=""

	if [ ${RETVAL} -eq 0 ]
	then
		TMPPRINT="already present"
	fi

	if [ ${RETVAL} -eq 1 ]
	then
		echo "\n${LAYER_VOIPAC_STRING}" >> ${LAYERS_DIR}/bblayers.conf
		TMPPRINT="added"
	fi

	echo "Layer meta-fsl-arm-voipac ${TMPPRINT}"
fi
