// Get a random garden tip

var gardeningTips = [
    "Pay attention to how sunlight plays through your yard before choosing a spot for your garden. Most edible plants, including many vegetables, herbs, and fruits, need at least 6 hours of sun in order to thrive.",
    "Plan your new garden near a water source. Make sure you can run a hose to your garden site, so you don't have to lug water to it each time your plants get thirsty.",
    "The best way to tell if plants need watering is to push a finger an inch down into the soil (that's about one knuckle deep). If it's dry, it's time to water.",
    "Paint the handles of your gardens tools a bright, color other than green to help you find them amongst your plants. You can also keep a mailbox in your garden for easy tool storage.",
    "Compost needs time to integrate and stabilize in the soil. Apply two to three weeks prior to planting.",
    "Garden vegetables that become over-ripe are an easy target for some pests. Remove them as soon as possible to avoid detection.",
    "Insects can’t stand plants such as garlic, onions, and chives. Grow these plants around the garden to help repel insects.",
    "Milk jugs, soda bottles and other plastic containers make great mini-covers to place over your plants and protect them from frost.",
    "Healthy soil means healthy plants that are better able to resist pests and disease, reducing the need for pesticides.",
    "Earthworms are extremely beneficial in the vegetable garden; increasing air space in the soil and leaving behind worm castings. Do what you can to encourage earthworms in your soil.",
    "Some vegetables actually become better after a first frost, including cabbage, parsnips, carrots, and Brussels sprouts.",
    "Water your garden in the early morning to conserve moisture loss and to help avoid powdery mildew and other fungal diseases that are often spread by high humidity levels.",
    "Over watering is worse than under watering. It is easier to revive a dry plant than try to dry out drowned roots.",
    "A net over top of your garden is a great way to keep birds and other larger pests from bothering your plants.",
    "Know your USDA Hardiness Zone. Use it as a guide so you don't plant trees, shrubs, and perennials that won't survive conditions in your area. You'll also get a better idea of when to plant vegetables and fruits in your area.",
    "The best approaches to controlling weeds in the garden are hand-weeding and hoeing. Avoid deep hoeing or cultivating that can bring weed seeds to the soil's surface. Weed early and often so weeds don't go to seed. Use mulch to smother and prevent annual weeds.",
    "If your rhubarb sends up flower stalks, remove them so the plant will focus on foliage production, not seed production.",
    "When transplanting container-grown plants, dig a hole larger than the soil ball of the plant to aid with root establishment.",
    "Don't send your fall leaves away! Chop them up and use them as compost ingredients. Pulverized leaves can be left to nourish the lawn. After several hard freezes, when plants have gone completely dormant, you also can use 3-6 inches of shredded leaves as mulch over tender perennials to keep them dormant over winter. Remove the mulch in spring."
];

function getAClue(array) {
    var randomNum = Math.floor(Math.random() * Math.floor(array.length - 1));
    return array[randomNum];
}

$("#just-the-tip").append(getAClue(gardeningTips));
