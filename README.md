# MatchPoint ⚡🏐

Aplicativo Android para **organização de partidas de vôlei**, formação de equipes e acompanhamento do placar.

## Funcionalidades

- **Turmas e jogadores:** cadastre participantes, organize grupos e registre quem está presente.
- **Sorteio e escalação:** monte equipes equilibradas ou manualmente, com jogadores aguardando e possibilidade de entrada tardia.
- **Edição visual:** mova jogadores entre times e a área de espera, com prévia do nome durante o arraste e destaque do destino.
- **Placar da partida:** pontuação por gestos, números com efeito mecânico de virar folha, inversão de lados e modo de tela cheia.
- **⚡ Placar rápido:** placar independente de cadastro, com nomes e cores das equipes, múltiplas equipes disponíveis, tela cheia, animação e histórico de sets.
- **Partidas e ranking:** acompanhe resultados confirmados e desempenho dos jogadores.

## Tecnologia

Projeto Android que utiliza uma **WebView** com interface em HTML, CSS e JavaScript, empacotada no aplicativo. Os dados da versão atual são mantidos **localmente no dispositivo**.

## Como gerar o APK

1. Abra a aba **Actions** do repositório.
2. Selecione **Gerar APK MatchPoint**.
3. Execute o workflow manualmente ou aguarde a execução automática após uma atualização.
4. Após uma compilação bem-sucedida, baixe o artefato **MatchPoint-Versao-10-Android**.
5. Extraia o arquivo `app-debug.apk` do ZIP e instale em um dispositivo Android compatível.

A compilação utiliza Java 17, Gradle e Android SDK no GitHub Actions.

> **Atenção:** o APK do workflow é uma versão de testes (`debug`). A distribuição definitiva exigirá assinatura de lançamento e testes adicionais em dispositivos reais.

## Organização

- `app/src/main/assets/index.html`: interface e lógica do MatchPoint.
- `app/src/main/assets/manifest.webmanifest`: metadados da interface web.
- `app/src/main/AndroidManifest.xml`: configuração do aplicativo Android.
- `.github/workflows/android-apk.yml`: compilação automatizada do APK.

---

**MatchPoint** · Organização do vôlei com mais agilidade e uma experiência visual clara.
