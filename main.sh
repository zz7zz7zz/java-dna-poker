#!/bin/bash

#---------------------------启动Start---------------------------

#---------------------------启动监视器---------------------------
cd Monitor
./start.sh
cd ../

#暂停3秒
sleep 3

#---------------------------启动Dispatcher---------------------------
cd Dispatcher
./start.sh
cd ../

#暂停3秒
sleep 3

#---------------------------启动Access---------------------------
cd Access
./start.sh
cd ../

#暂停10秒

#---------------------------启动End---------------------------


