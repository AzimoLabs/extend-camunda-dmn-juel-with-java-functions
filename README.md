## Camunda Spring Boot example with JUEL custom functions
This example contains ready to run Spring Boot application with Camunda where JUEL expression language is extended.
There are two ways how JUEL can be extended. Extensions are implemented as:

* `Spring beans` - they are registered as expression language extensions in `SpringExpressionManager` by default and all methods from registered beans can be accessed in DMN
* `Function mappers` - they are registered in ExpressionManager manually and they map EL functions into static Java methods

Decision DMN with custom functions used is shown [here](https://github.com/AzimoLabs/extend-camunda-dmn-juel-with-java-functions/blob/master/src/main/resources/dmn/compliance.dmn)

### Decision Requirements Graph used in example
![Alt text](picture/compliance_decision_drd.png?raw=true "Architecture")

## Authors
* **Jakub Legowik** - [e-mail](kuba.legowik@gmail.com)

# License

    Copyright (C) 2016 Azimo

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
