#!/usr/bin/env bash
docker build -t e-grocer/frontend .
docker run -p 3000:3000 -it e-grocer/frontend