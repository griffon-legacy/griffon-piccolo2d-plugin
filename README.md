
Piccolo2d powered scenegraph
----------------------------

Plugin page: [http://artifacts.griffon-framework.org/plugin/piccolo2d](http://artifacts.griffon-framework.org/plugin/piccolo2d)


Provides integration with [Piccolo2D][1], a toolkit that supports the development of 2D structured graphics program.

Usage
-----

The following nodes will become available on a View script upon installing this plugin

| *Node*       | *Type*                                    |
| ------------ | ----------------------------------------- |
| pcanvas      | `edu.umd.cs.piccolo.PCanvas`              |
| phtmlView    | `edu.umd.cs.piccolo.nodes.PHtmlView`      |
| pimage       | `edu.umd.cs.piccolo.nodes.PImage`         |
| ppath        | `edu.umd.cs.piccolo.nodes.PPath`          |
| pnode        | `edu.umd.cs.piccolo.PNode`                |
| ptext        | `edu.umd.cs.piccolo.nodes.PText`          |
| pswingCanvas | `edu.umd.cs.piccolox.pswing.PSwingCanvas` |
| pscrollPane  | `edu.umd.cs.piccolox.swing.PScrollPane`   |
| pcomposite   | `edu.umd.cs.piccolox.nodes.PComposite`    |
| pstyleText   | `edu.umd.cs.piccolox.nodes.PStyledText`   |

`ppath` accepts an addtional `shape:` property that must be of type `java.awt.Shape`.

**Important**

Any `JComponent` nodes added inside the hierarchy of a `pcanvas`/`pswingCanvas` will be automatically wrapped using a `PSwing` node, which means
the `JComponent` will be inserted in the scene graph.

The following nodes are unique to this plugin

| *Node*          | *Property* | *Type*            |
| --------------- | ---------- | ----------------- |
| prectangle      | x          | float             |
|                 | y          | float             |
|                 | width      | float             |
|                 | height     | float             |
| proundRectangle | x          | float             |
|                 | y          | float             |
|                 | width      | float             |
|                 | height     | float             |
|                 | arcWidth   | float             |
|                 | arcHeight  | float             |
| pellipse        | x          | float             |
|                 | y          | float             |
|                 | width      | float             |
|                 | height     | float             |
| pline           | x1         | float             |
|                 | y1         | float             |
|                 | x2         | float             |
|                 | y2         | float             |
| ppolyLine       | points     | List&lt;float&gt; |

Transformation nodes can be applied to any node

| *Node*         | *Property* | *Type*          | *Notes*                                  |
| -------------- | ---------- | --------------- | ---------------------------------------- |
| transformation |            |                 | accepts any transformation as child      |
| rotate         | theta      | double          |                                          |
|                | x          | double          |                                          |
|                | y          | double          |                                          |
|                | inplace    | double          |                                          |
| scale          | factor     | double          |                                          |
| translate      | dx         | double          |                                          |
|                | dy         | double          |                                          |
| transform      | append     | boolean         | modifies the current transform if `true` |
|                | transform  | AffineTransform |                                          |

### Example

The following example draws 4 Rectangles with different fill colors and rotations

        application(title: 'Piccolo2D',
          preferredSize: [300, 320],
          pack: true,
          locationByPlatform:true,
          iconImage: imageIcon('/griffon-icon-48x48.png').image,
          iconImages: [imageIcon('/griffon-icon-48x48.png').image,
                       imageIcon('/griffon-icon-32x32.png').image,
                       imageIcon('/griffon-icon-16x16.png').image]) {
            pcanvas {
                [[color: Color.BLUE,   size: 300d], 
                 [color: Color.RED,    size: 212d],
                 [color: Color.YELLOW, size: 150d],
                 [color: Color.GREEN,  size: 106d]].eachWithIndex { data, index ->
                    prectangle(width: data.size, height: data.size, paint: data.color) {
                        ptransformations {
                            protate(theta: Math.toRadians(45d * index), inplace: true)
                        }
                    }
                }
            }
        }

[1]: http://www.piccolo2d.org

