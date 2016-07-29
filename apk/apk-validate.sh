#!/bin/bash
######################################################################
# Command-line interface for apk-validate function
# See comments in apk-validate file for documentation
######################################################################
# (c) Eliot Lash 2016 - Apache license 2.0
######################################################################
set -o pipefail
set -o nounset

source apk-validate

apk-validate "$@"
