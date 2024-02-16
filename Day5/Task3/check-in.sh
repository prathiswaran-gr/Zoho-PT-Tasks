
checkin_time=$(date +"%Y-%m-%d %H:%M:%S")

redis-cli SET checkin_time "$checkin_time"

echo "Checked in at: $checkin_time"

