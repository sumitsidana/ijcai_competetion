cd java
javac preProcess/FFMInputOperate.java preProcess/WriteFFMInput.java

for countryCode in "at" "be" "br" "ch" "cz" "de" "dk" "es" "fi" "ie" "nb" "nl" "no" "pl" "pt" "ru" "se" "uk" "it" "fr"; do
    start=$(date +%s.%N)
    filename1="/home/ama/sidana/ffminput/tabseparated/train_$countryCode.csv"
    filename2="/home/ama/sidana/ffminput/tabseparated/test_$countryCode.csv"
    filename3="/home/ama/sidana/ffminput/ffminput/$countryCode.ffm.train"
    filename4="/home/ama/sidana/ffminput/ffminput/$countryCode.ffm.test"
	java -Xmx50g -cp . preProcess.FFMInputOperate "$filename1" "$filename2" "$filename3" "$filename4"
    dur=$(echo "$(date +%s.%N) - $start" | bc)
    echo "$countryCode:$dur">>/home/ama/sidana/ffminput/ffminput/ffminputoperatetrain.txt
done
cd -
