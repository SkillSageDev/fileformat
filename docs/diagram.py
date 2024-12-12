# Let's generate a simple UML diagram using Graphviz and export it as a `.drawio` file.
from graphviz import Digraph

# Create a Digraph instance
uml_diagram = Digraph(comment='Checker System UML Diagram', format='png')
uml_diagram.attr(rankdir='LR', size='10')

# Nodes (classes)
uml_diagram.node('Checker', 'Checker\n+getAudioType(File)\n-reader: AudioReader\n-audioCheckers: List<AudioChecker>')
uml_diagram.node('AudioReader', '<<interface>>\nAudioReader\n+getHeader(File, int): byte[]')
uml_diagram.node('Reader', 'Reader\n+getHeader(File, int): byte[]')
uml_diagram.node('AudioChecker', '<<interface>>\nAudioChecker\n+getAudioType(byte[]): String')
uml_diagram.node('Mp3Checker', 'Mp3Checker\n+getAudioType(byte[]): String')
uml_diagram.node('WavChecker', 'WavChecker\n+getAudioType(byte[]): String')
uml_diagram.node('File', 'File')

# Relationships (arrows)
uml_diagram.edge('Checker', 'AudioReader', label='depends on')
uml_diagram.edge('Reader', 'AudioReader', arrowhead='onormal', label='implements')
uml_diagram.edge('Checker', 'AudioChecker', label='depends on (List)')
uml_diagram.edge('Mp3Checker', 'AudioChecker', arrowhead='onormal', label='implements')
uml_diagram.edge('WavChecker', 'AudioChecker', arrowhead='onormal', label='implements')
uml_diagram.edge('Checker', 'File', label='uses')
uml_diagram.edge('AudioReader', 'File', label='uses')

# Save and visualize the diagram in drawio
uml_diagram.render('/mnt/data/CheckerSystem_UMLDiagram')

# Return the image for display
'/mnt/data/CheckerSystem_UMLDiagram.png'
