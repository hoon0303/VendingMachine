# VendingMachine

VendingMachine 프로젝트는 자판기 시스템을 시뮬레이션하는 Java 기반 애플리케이션입니다. 이 프로젝트는 사용자가 다양한 음료를 선택하고 구매할 수 있도록 도와주며, 자판기의 재고 및 잔돈 계산 기능을 포함합니다. 또한, 소켓을 사용하여 네트워크 상의 다른 시스템과 통신할 수 있습니다.

## 주요 기능
- **음료 선택**: 사용자는 다양한 음료 중에서 선택할 수 있습니다.
- **잔돈 계산**: 정확한 잔돈을 계산하고 반환합니다.
- **재고 관리**: 각 음료의 재고를 관리합니다.
- **사용자 인터페이스**: Java Swing을 사용한 GUI 기반의 사용자 친화적인 인터페이스를 제공합니다.
- **소켓 통신**: 소켓을 사용하여 네트워크 상의 다른 시스템과 통신합니다.

## 파일 구조
```plaintext
VendingMachine-master/
├── .classpath
├── .project
├── .settings/
├── bin/
└── src/
    └── project/
        ├── AdminItem.java
        ├── AdminMenu.java
        ├── AdminMoney.java
        ├── AdminPassword.java
        ├── AdminPasswordChange.java
        ├── Cpanel.java
        ├── Data.java
        ├── Machine.java
        ├── item.java
        └── money.java
