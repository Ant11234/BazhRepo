---

---

```python

from IPython.display import display, HTML, Javascript
import ipywidgets as widgets

def create_menu():
    menu = widgets.Tab()
    menu.children = [widgets.Textarea('About Me: Add your detailed description here.'),
                     widgets.Textarea('Projects: List and describe your projects here.'),
                     widgets.Textarea('Skills: Visualize and describe your skills here.'),
                     widgets.Textarea('Contact: Add your contact information here.')]
    menu.set_title(0, 'About Me')
    menu.set_title(1, 'Projects')
    menu.set_title(2, 'Skills')
    menu.set_title(3, 'Contact')
    display(menu)

create_menu()

```


    Tab(children=(Textarea(value='About Me: Add your detailed description here.'), Textarea(value='Projects: List …

