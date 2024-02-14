const colors = ["red", "blue", "green", "orange", "pink", "black"];
const ColorSelect = ({ setColor }) => {
  const onClick = (color) => {
    setColor((prevState) => {
      console.log(prevState);
      return color;
    });
  };

  return (
    <div>
      {colors.map((color) => (
        <button type="button" key={color} onClick={() => onClick(color)}>
          {color}
        </button>
      ))}
    </div>
  );
};

export default ColorSelect;
