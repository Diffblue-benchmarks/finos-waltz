#!/usr/bin/env bash

# The existing unit tests require that a postgres docker container is running.
# The below arguments were adapted from .github/workflows/maven.yml

docker run --detach --name local-postgres \
--env POSTGRES_USER=postgres \
--env POSTGRES_DB=waltz \
--env POSTGRES_PASSWORD=postgres \
--publish 5432:5432 \
--health-cmd="pg_isready" \
--health-interval=10s \
--health-timeout=5s \
--health-retries=5 postgres:15