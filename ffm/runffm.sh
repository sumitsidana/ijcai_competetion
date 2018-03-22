./ffm-train -p /data/sidana/ijcai_competetion/baselines/ffm/test_va.csv.libffm -s 16 -l 0.001 -k 8 -r 0.2 -t 1000 --auto-stop /data/sidana/ijcai_competetion/baselines/ffm/train_va.csv.libffm  /data/sidana/ijcai_competetion/baselines/ffm/model
./ffm-train  -s 16 -l 0.001 -k 8 -r 0.2 -t 174 /data/sidana/ijcai_competetion/baselines/ffm/train.csv.libffm  /data/sidana/ijcai_competetion/baselines/ffm/model
./ffm-predict /data/sidana/ijcai_competetion/baselines/ffm/test.csv.libffm /data/sidana/ijcai_competetion/baselines/ffm/model /data/sidana/ijcai_competetion/baselines/ffm/output
