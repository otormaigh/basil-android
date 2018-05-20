#!/usr/bin/env bash

function cleanup {
  echo "Deleting keys"
  rm -f buildSrc/src/main/java/KeyStore.kt
  rm -f signing/release.keystore
  rm -f signing/play.json
}
trap cleanup EXIT

sh script/decrypt.sh
# TODO generate changelog based on commits
./gradlew publishApkRelease