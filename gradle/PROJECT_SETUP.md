# AuraFrameFX Project Setup Guide

This guide covers everything you need to get started with AuraFrameFX: local development, repository management, CI/CD, secrets, and contribution workflow.

---

## 1. Prerequisites

- **Android Studio** (latest stable)
- **JDK 11+**
- **Git** (latest)
- **Google Cloud Vertex AI** access (API keys)
- **Firebase Project** (for `google-services.json`)
- (Optional) **Rooted device/emulator** for Xposed/LSPosed testing

---

## 2. Repository Structure (Key Directories)

| Path        | Purpose                                    |
|-------------|--------------------------------------------|
| /app        | Main Android app source code                |
| /modules    | Xposed/LSPosed modules and overlays         |
| /test       | Unit and instrumentation tests              |
| /docs       | Documentation, diagrams, architecture       |
| /scripts    | Automation scripts, CI/CD helpers           |
| /.github    | GitHub Actions, issue templates, configs    |

---

## 3. Cloning and Initial Setup

```bash
git clone https://github.com/AuraFrameFxDev/AuraFrameFx.git
cd AuraFrameFx
```

---

## 4. Secrets and Configuration

- Place your **Firebase config** at:  
  `app/google-services.json`
- Place your **Vertex AI credentials** at:  
  `app/vertex_service_account.json`
- Configure sensitive values in:  
  - `app/src/main/res/values/secure_config.xml`
  - `app/src/main/res/values/oauth.xml`

**Never commit secrets!**  
These files should be listed in `.gitignore`.

---

## 5. Building & Running

1. Open the project in **Android Studio**.
2. Sync Gradle and let dependencies resolve.
3. Place your config files (`google-services.json`, etc.) in the correct locations.
4. **Build** and **Run** on your device/emulator.

---

## 6. GitHub Actions (CI/CD)

- CI builds on every PR and push to `main`/`dev`.
- Workflow file: `.github/workflows/android.yml`
- Automatic linting, unit tests, and APK artifact upload.
- You can download APKs from the "Actions" tab after a successful run.

---

## 7. Branching & Collaboration

- **main**: Production-ready code
- **dev**: Integration branch for features/fixes
- **feature/xxx**: Per-feature branches
- Always open PRs to `dev`, not `main`
- All PRs require review and passing CI

---

## 8. Issue Tracking

- Use [GitHub Issues](https://github.com/AuraFrameFxDev/AuraFrameFx/issues) for bugs, features, and tasks.
- Label issues for easy triage (`bug`, `feature`, `good first issue`, etc.).
- Reference issues in PRs with `Fixes #123`.

---

## 9. Contributing

- Fork the repo if external, or branch if internal.
- Always branch from `dev`.
- Make your changes, run tests, and push your branch.
- Open a Pull Request to `dev` and request review.
- Include clear commit messages and update docs if needed.

---

## 10. Documentation

- **Quick Start**: See this file and `README.md`.
- **Detailed Docs**: In `/docs` (architecture, guides).
- **Diagrams**: Use markdown or diagrams.net files in `/docs`.

---

## 11. Security & Secrets (CI/CD)

- Use **GitHub Secrets** for keys in workflows.
- Never hardcode API keys or credentials in code or workflows.
- Document how contributors can set up local secrets.

---

## 12. Testing

- Run `./gradlew test` for unit tests.
- Instrumentation tests can be run in Android Studio or via the command line.

---

## 13. Build Artifacts

- APKs are built and stored as artifacts in GitHub Actions.
- For release builds, see the [Releases](https://github.com/AuraFrameFxDev/AuraFrameFx/releases) tab.

---

## 14. Contact

- Project Lead: **Slate Fielder**
- Home: [AuraFrameFxDev/AuraFrameFx](https://github.com/AuraFrameFxDev/AuraFrameFx)

---

## 15. Example .gitignore

```gitignore
# Android / Java / Kotlin
.idea/
.gradle/
local.properties
*.iml
build/
captures/
output.json

# Secrets
app/google-services.json
app/vertex_service_account.json
*.keystore
*.jks

# OS
.DS_Store
Thumbs.db
```

---

## 16. Troubleshooting

- **Build fails?** Ensure all config files are present and JDK version is correct.
- **CI fails?** Check the Actions log for missing secrets or dependency issues.
- **Feature doesn’t work?** Check the [Issues](https://github.com/AuraFrameFxDev/AuraFrameFx/issues) or open a new one.

---

AuraFrameFX is your luminous, evolving AI companion at the intersection of intelligence and imagination.

