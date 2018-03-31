
fn=uppercase

riff delete --all --force

for i in {${fn}-topics.yaml,${fn}-function.yaml,Dockerfile} ; do
 rm -rf $i
done

mvn -f ./pom.xml clean package

riff create java -a  target/riff-0.0.1-SNAPSHOT.jar --force --name $fn --input $fn --handler "$fn&main=com.example.riff.RiffApplication"

riff publish --content-type application/json -i $fn -d'{"value":"hi riff"}'  -r
