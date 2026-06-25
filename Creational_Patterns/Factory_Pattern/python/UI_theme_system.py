from abc import ABC, abstractmethod

# Abstract Products
class Button(ABC):
    @abstractmethod
    def render(self): pass

class CheckBox(ABC):
    @abstractmethod
    def select(self): pass

# Concrete Products
class LightButton(Button):
    def render(self): print("Rendering Light Button")

class DarkButton(Button):
    def render(self): print("Rendering Dark Button")

class LightCheckBox(CheckBox):
    def select(self): print("Selecting Light Checkbox")

class DarkCheckBox(CheckBox):
    def select(self): print("Selecting Dark Checkbox")


# Abstract Factory
class ThemeFactory(ABC):
    @abstractmethod
    def create_button(self) -> Button: pass
    @abstractmethod
    def create_checkbox(self) -> CheckBox: pass

# Concrete Factories
class LightThemeFactory(ThemeFactory):
    def create_button(self): return LightButton()
    def create_checkbox(self): return LightCheckBox()

class DarkThemeFactory(ThemeFactory):
    def create_button(self): return DarkButton()
    def create_checkbox(self): return DarkCheckBox()


# ThemeService — fully resolves everything internally
class ThemeService:
    _registry = {
        "light": LightThemeFactory,
        "dark": DarkThemeFactory,
    }

    def __init__(self, theme: str):
        theme = theme.lower()
        if theme not in self._registry:
            raise ValueError(f"Unknown theme: '{theme}'")
        self._factory = self._registry[theme]()  # resolved once, stored

    def render_button(self):
        self._factory.create_button().render()

    def render_checkbox(self):
        self._factory.create_checkbox().select()

    def render_all(self):
        self.render_button()
        self.render_checkbox()


# Client — only knows "light" or "dark", nothing else
if __name__ == "__main__":
    ThemeService("light").render_all()
    ThemeService("dark").render_all()