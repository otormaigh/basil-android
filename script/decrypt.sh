#!/bin/bash

set -e

# Echoes extra logging info
log() {
  if [ "$VERBOSE" = true ]
    then
      echo "--${1}"
  fi
}

# Checks if an env value is present and not empty
checkEnv() {
  echo "Checking"
  env_value=$(printf '%s\n' "${!1}")
  if [ -z ${env_value} ]; then
    echo "$1 is undefined, exiting..."
    exit 1
  else
    log "Found value for $1"
  fi
}

checkEnv PENNY_ENCRYPT_KEY

echo "Decrypting files"
openssl aes-256-cbc -a -d -in buildSrc/src/main/java/KeyStore.kt.aes -out buildSrc/src/main/java/KeyStore.kt -k $PENNY_ENCRYPT_KEY
openssl aes-256-cbc -a -d -in signing/release.keystore.aes -out signing/release.keystore -k $PENNY_ENCRYPT_KEY
openssl aes-256-cbc -a -d -in signing/play.json.aes -out signing/play.json -k $PENNY_ENCRYPT_KEY
log "Files decrypted"

echo "Finishing up"