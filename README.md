# Antlr 4

## Install Antlr

1. Download Antlr-4.12.0 jar file from [antlr.org](https://www.antlr.org/download.html)

2. Move downloaded `jar` to `/usr/local/lib`

3. Add configs to my `.zshrc` as following

   ```
   # ANTLR4
   alias antlr4='java -jar /usr/local/lib/antlr-4.12.0-complete.jar'
   export CLASSPATH="/usr/local/lib/antlr-4.12.0-complete.jar:$CLASSPATH"
   alias grun='java org.antlr.v4.gui.TestRig'
   ```
4. Verification Installation

   ```shell
    ❯ grun
    java org.antlr.v4.gui.TestRig GrammarName startRuleName
    [-tokens] [-tree] [-gui] [-ps file.ps] [-encoding encodingname]
    [-trace] [-diagnostics] [-SLL]
    [input-filename(s)]
    Use startRuleName='tokens' if GrammarName is a lexer grammar.
    Omitting input-filename makes rig read from stdin.
    ❯
    ❯ antlr4
    ANTLR Parser Generator  Version 4.12.0
    -o ___              specify output directory where all output is generated
    -lib ___            specify location of grammars, tokens files
    -atn                generate rule augmented transition network diagrams
    -encoding ___       specify grammar file encoding; e.g., euc-jp
    -message-format ___ specify output style for messages in antlr, gnu, vs2005
    -long-messages      show exception details when available for errors and warnings
    -listener           generate parse tree listener (default)
    -no-listener        don't generate parse tree listener
    -visitor            generate parse tree visitor
    -no-visitor         don't generate parse tree visitor (default)
    -package ___        specify a package/namespace for the generated code
    -depend             generate file dependencies
    -D<option>=value    set/override a grammar-level option
    -Werror             treat warnings as errors
    -XdbgST             launch StringTemplate visualizer on generated code
    -XdbgSTWait         wait for STViz to close before continuing
    -Xforce-atn         use the ATN simulator for all predictions
    -Xlog               dump lots of logging info to antlr-timestamp.log
    -Xexact-output-dir  all output goes into -o dir regardless of paths/package
   ```
