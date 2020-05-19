# /usr/bin/bash

sed -i "s~{RELEASE}~$RELEASE~g" /etc/nginx/nginx.conf
sed -i "s~{NAMESPACE}~$NAMESPACE~g" /etc/nginx/nginx.conf
sed -i "s~{PORT}~$PORT~g" /etc/nginx/nginx.conf
echo 'do convert.sh seccess ============ ok'
# nginx reload
nginx -g "daemon off"

