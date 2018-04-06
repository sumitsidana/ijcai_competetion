#./ffm-train -p /data/sidana/ijcai_competetion/baselines/ffm/test_val.csv.libffm -s 30 -l 0.0001 -k 150 -r 0.05 -t 1000 --auto-stop /data/sidana/ijcai_competetion/baselines/ffm/train_val.csv.libffm  /data/sidana/ijcai_competetion/baselines/ffm/model
./ffm-train  -s 30 -l 0.0001 -k 150 -r 0.05 -t 16 /data/sidana/ijcai_competetion/baselines/ffm/train.csv.libffm  /data/sidana/ijcai_competetion/baselines/ffm/model
./ffm-predict /data/sidana/ijcai_competetion/baselines/ffm/test.csv.libffm /data/sidana/ijcai_competetion/baselines/ffm/model /data/sidana/ijcai_competetion/baselines/ffm/output
