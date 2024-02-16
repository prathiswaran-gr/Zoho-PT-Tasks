
checkout_time=$(date +"%Y-%m-%d %H:%M:%S")

checkin_time=$(redis-cli GET checkin_time)

if [ "$checkin_time" ]; then
	checkin_time_in_seconds=$(date -d "$checkin_time" +"%s")
	checkout_time_in_seconds=$(date -d "$checkout_time" +"%s")

	seconds_worked=$((checkout_time_in_seconds - checkin_time_in_seconds))
	
	hours_worked=$(($seconds_worked / 3600))

	echo "Checked out at: $checkout_time"
	echo "Worked for: $hours_worked hours $((seconds_worked / 60)) minutes"
	
	redis-cli DEL checkin_time
else
  	echo "Error: No check-in time found. Please check in first."
fi



