Forward your ssh-agent socket into a container:

```bash
$ git clone git@github.com:uber-common/docker-ssh-agent-forward.git
$ make 
$ make install
$ pinata-ssh-forward
```

Start docker dind container:

```bash
docker run --rm --privileged --name dind -d docker:stable-dind
```

```bash
$ ./run.sh build
```
