# Sextou Vôlei — aplicativo Android (teste gratuito)

Este pacote inclui o **projeto Android** baseado no protótipo V9. O APK precisa ser compilado; ele ainda NÃO está neste ZIP.

## Criar APK gratuitamente no GitHub (sem Android Studio)

1. Entre em https://github.com/new e crie um repositório, por exemplo `SextouVoleiAndroid`.
2. Extraia o ZIP no computador. No repositório, clique em **Add file > Upload files** e envie os **arquivos e pastas internos** (incluindo `.github`, `app`, `build.gradle`, `settings.gradle` e `gradle.properties`). O ZIP sozinho não é suficiente. Dica: no Windows, arquivos/pastas iniciados em ponto podem ficar ocultos.
3. Clique em **Commit changes**.
4. Abra a aba **Actions** do repositório. Se necessário, habilite Actions. Selecione **Gerar APK Sextou Volei** e clique **Run workflow**. O fluxo também executa automaticamente em pushes à branch `main` ou `master`.
5. Espere a compilação. Se ficar verde, entre na execução e baixe, em **Artifacts**, o arquivo `SextouVolei-APK-Android`.
6. Extraia o ZIP do artifact. Dentro estará o verdadeiro `app-debug.apk`. Transfira ao Android e abra para instalar, autorizando instalação dessa origem apenas se confiar no arquivo.

### Alternativa: Android Studio
Abra esta pasta como projeto no Android Studio, espere o Gradle sincronizar, e selecione **Build > Build APK(s)**. O arquivo será gerado em `app/build/outputs/apk/debug/app-debug.apk`.

## Importante antes de usar de verdade
- É um **APK de teste**, não uma versão de produção revisada ou publicada na Play Store.
- Todo o conteúdo principal do aplicativo está embarcado para uso offline, mas fontes externas poderão cair para as fontes padrão se não houver internet.
- Jogadores, placares e ranking usam o armazenamento interno do WebView (localStorage): **não há Supabase nem sincronização entre dispositivos**.
- Os jogadores fictícios da demonstração aparecem ao iniciar um armazenamento vazio. Você pode excluí-los dentro do app.
- Desinstalar ou limpar os dados do app pode apagar tudo. **Não use para resultados oficiais sem backup**.
- Atualizações futuras usando outro identificador ou uma assinatura diferente podem não preservar o armazenamento local.
- Este projeto não foi compilado nem testado em aparelho Android neste ambiente; verifique o resultado após a compilação.
