#!/usr/bin/env bash

set -e

# Echoes extra logging info
function log {
  if [ "$VERBOSE" = true ]
    then
      echo "--${1}"
  fi
}

# Checks if an env value is present and not empty
function checkEnv {
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

echo "Encrypting files"
openssl aes-256-cbc -a -in buildSrc/src/main/java/KeyStore.kt -out enc/KeyStore.kt.aes -k $PENNY_ENCRYPT_KEY
openssl aes-256-cbc -a -in signing/release.keystore -out enc/release.keystore.aes -k $PENNY_ENCRYPT_KEY
openssl aes-256-cbc -a -in signing/play.json -out enc/play.json.aes -k $PENNY_ENCRYPT_KEY
openssl aes-256-cbc -a -in app/src/main/res/values/font_certs.xml -out enc/font_certs.xml.aes -k $PENNY_ENCRYPT_KEY
log "Files encrypted"

echo "Finishing up"