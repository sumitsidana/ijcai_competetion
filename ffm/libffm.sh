cd ~/recsysBaselines/code/cplusplus/libffm-1.14/
#"at" "be" "br" "ch" "cz" "de" "dk" "fi" "nb" "nl" "no" "pl" "pt" "ru" "se" "uk" "it" "fr"
for countryCode in "ie"; do
     echo $countryCode
     start1=$(date +%s.%N)
     ./ffm-train -p /data/sidana/recsysBaselines/bug_december/ffmcountryfiles/input/userofferclicks/$countryCode.ffm.test -s 16 -l 0.001 -k 8 -r 0.2 --auto-stop /data/sidana/recsysBaselines/bug_december/ffmcountryfiles/input/userofferclicks/$countryCode.ffm.train  /data/sidana/recsysBaselines/bug_december/ffmcountryfiles/input/userofferclicks/model/$countryCode.model
     dur=$(echo "$(date +%s.%N) - $start1" | bc)
     echo "$countryCode:$dur">>/data/sidana/recsysBaselines/bug_december/ffmcountryfiles/input/userofferclicks/traintime/libffm.txt
     start2=$(date +%s.%N)      
     ./ffm-predict /data/sidana/recsysBaselines/bug_december/ffmcountryfiles/input/userofferclicks/$countryCode.ffm.test /data/sidana/recsysBaselines/bug_december/ffmcountryfiles/input/userofferclicks/model/$countryCode.model /data/sidana/recsysBaselines/bug_december/ffmcountryfiles/input/userofferclicks/output/$countryCode.output
     dur=$(echo "$(date +%s.%N) - $start2" | bc)
     echo "$countryCode:$dur">>/data/sidana/recsysBaselines/bug_december/ffmcountryfiles/input/userofferclicks/predicttime/libffm.txt
     done
cd -
