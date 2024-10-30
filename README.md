# Potentially Duplicates

Generates a report about potentially duplicated contacts from input csv.

## Requirements
- JDK 17: [Installing the JDK Software and Setting JAVA_HOME](https://docs.oracle.com/cd/E19182-01/820-7851/inst_cli_jdk_javahome_t/)
- Maven: [Installing Apache Maven](https://maven.apache.org/install.html/) (verified for version 3.6.3)

## Installation

In the root folder of the project execute:

```bash
mvn clean package
```

## Usage

By default, the program use the home directory for the input csv.
After run the package command, execute:

```bash
java -jar target/CompassPotentialDuplicates-1.0.jar
```

If you prefer to specify the input csv, use for example:

```bash
java -jar target/CompassPotentialDuplicates-1.0.jar "C:\Users\MYUSER\Desktop\Code Assessment - Find Duplicates Input - SampleCodecsv (1) (1).csv" "C:\Users\MYUSER\Desktop\PotentiallyMatches.csv"
```
