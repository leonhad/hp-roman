# HP Roman charset support

This project aims to add the HP Roman charset support to Java.

To use it, just add the package to your project. This will add support to the charset automatically.

[![License](https://img.shields.io/badge/License-GPL%203.0-blue.svg)](LICENSE)

## Example ##

```java
    Charset charset = Charset.forName("roman8");
    // Use your charset here.
```

## Supported charsets

### HP Roman 8

* roman8
* IBM1051
* IBM-1051
* cp1051
* cp-1051
* hp-roman8
* HP_ROMAN8
* ROMAN8
* r8
* R8

### HP Roman 8 extensions

* cp1050
* cp-1050
* IBM1050
* IBM-1050

### HP Roman 8 variation I

There is no official name for HP Roman 8 variation I, see more in https://en.wikipedia.org/wiki/HP_Roman in Modified Roman-8.

* roman8-v1
* hp-roman8-v1
* HP_ROMAN8_V1
* ROMAN8_V1

### HP Roman 8 variation II

There is no official name for HP Roman 8 variation II, see more in https://en.wikipedia.org/wiki/HP_Roman in Modified Roman-8.

* roman8-v2
* hp-roman8-v2
* HP_ROMAN8_V2
* ROMAN8_V2

### HP Roman 9

* roman9
* hp-roman9
* HP_ROMAN9
* ROMAN9
* R9
* r9

# Downloads #
If you're using Maven, you can use the dependencies below:

```
<dependency>
    <groupId>io.github.leonhad</groupId>
    <artifactId>hp-roman</artifactId>
    <version>1.0.1</version>
</dependency>
```

If you're using Gradle, add the following line to your dependencies section:

    compile 'io.github.leonhad:hp-roman:1.0.1'

If you just want the files, you can grab the [latest release](https://github.com/leonhad/hp-roman/releases/latest).

# Licensing

This software is released under the GNU Lesser General Public License v3.0 (LGPLv3+).
Additionally, Autoconf includes a licensing exception in some of its
source files.

For more licensing information, see
<http://www.gnu.org/licenses/gpl-faq.html>.

-----
Copyright (C) 2024 Leonardo Alves da Costa.

Copying and distribution of this file, with or without modification,
are permitted in any medium without royalty provided the copyright
notice and this notice are preserved.  This file is offered as-is,
without warranty of any kind.
